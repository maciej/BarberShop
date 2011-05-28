package org.inszy.barbershop

import akka.actor.{PoisonPill, Actor}

class SimpleActorShop // Satisfy IDEA

object SimpleActorShop {
  def main(args : Array[String]) : Unit = {
    val helloActor = Actor.actorOf[SayingHelloActor]
    helloActor.start()
    helloActor ! "hello"
    helloActor ! PoisonPill
  }
}

class SayingHelloActor extends Actor {
  protected def receive() = {
    case "hello" => println("Hello (actor) World!")
  }
}