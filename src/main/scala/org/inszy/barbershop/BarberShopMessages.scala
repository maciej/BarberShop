package org.inszy.barbershop

import akka.actor.ActorRef

/**
 * Created by IntelliJ IDEA.
 * User: Maciej Biłas
 * Time: 12:27
 * Date: 5/29/11
 */

sealed abstract class BarberShopMessages

case object OpenTheShop extends BarberShopMessages

case object CloseTheShop extends BarberShopMessages

case class BarberGoesToSleep(barber: ActorRef) extends BarberShopMessages

case class CustomerComesIn(customer: ActorRef) extends BarberShopMessages