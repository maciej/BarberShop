package org.inszy.barbershop

import collection.mutable.Queue
import akka.actor.{ActorRef, PoisonPill, Actor}
import org.inszy.barbershop.Conversions._

/**
 * Created by IntelliJ IDEA.
 * User: Maciej Biłas
 * Date: 5/28/11
 * Time: 17:34
 */
object BarberShop {
  val totalNumberOfSeats = 2
  lazy val barberShop = Actor.actorOf[BarberShop]

  def main(args: Array[String]) = {
    barberShop.start()
    barberShop ! OpenTheShop
    bringInNewCustomer("Tony")
    bringInNewCustomer("Bill")
    bringInNewCustomer("Ariel")
    Thread.sleep(150)
    bringInNewCustomer("John")
    Thread.sleep(500)
    barberShop ! CloseTheShop
  }

  private def bringInNewCustomer(name: String) = {
    barberShop ! CustomerComesIn(Actor.actorOf(new Customer(name)).start())
  }
}

class BarberShop extends Actor {

  lazy val barbers = {
    (0 until BarberShop.totalNumberOfSeats).map {
      _ => Actor.actorOf(new Barber(self))
    }
  }

  val availableBarbers = new Queue[ActorRef]()

  def receive() = {
    case OpenTheShop =>
      barbers.foreach {
        barber => barber.start()
        availableBarbers.enqueue(barber)
      }
    case BarberGoesToSleep(barber) => availableBarbers.enqueue(barber)
    case CustomerComesIn(customer) => availableBarbers.dequeueOption() match {
      case Some(barber) => barber ! CutHair(customer)
      case None => customer ! AskToLeave
    }
    case CloseTheShop => {
      for (b <- barbers)
        b ! PoisonPill
      self ! PoisonPill
    }
  }
}

class Customer(val name: String) extends Actor {
  def receive() = {
    case AskToLeave => {
      println("%s: I left, oh well.".format(name))
      self ! PoisonPill
    }
    case AskForName => self.reply(name)
  }
}

class Barber(barberShop: ActorRef) extends Actor {

  def receive() = {
    case CutHair(customer) => {
      println("Cutting hair of %s".format((customer !! AskForName).getOrElse("unknwon")))
      Thread.sleep(100) // TODO add some random delay to observe nicer time relations
      barberShop ! BarberGoesToSleep(self)
      customer ! PoisonPill
    }
  }
}
