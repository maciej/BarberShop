package org.inszy.barbershop

import java.util.concurrent.atomic.AtomicInteger
import akka.actor.Actor

package

/**
 * Created by IntelliJ IDEA.
 * User: Maciej Biłas
 * Date: 5/28/11
 * Time: 17:34
 */

object BarberShop extends Actor {
  val totalNumberOfSeats = 2
  val freeSeats = new AtomicInteger(totalNumberOfSeats)

  def receive() = {
    
  }

  def main(args : Array[String]) = {
    
  }
}



class Customer extends Actor {
  def receive() = {
    
  }
}

class Barber extends Actor {
  def receive() = {
    
  }
}