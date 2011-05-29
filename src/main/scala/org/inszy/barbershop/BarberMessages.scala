package org.inszy.barbershop

import akka.actor.ActorRef

/**
 * Created by IntelliJ IDEA.
 * User: Maciej Biłas
 * Date: 5/29/11
 * Time: 12:29
 */

sealed abstract class BarberMessages

case class CutHair(customer: ActorRef) extends BarberMessages