package org.inszy.barbershop

/**
 * Created by IntelliJ IDEA.
 * User: Maciej Biłas
 * Date: 5/29/11
 * Time: 12:28
 */
sealed abstract class CustomerMessages

case object AskToLeave extends CustomerMessages

case object AskForName extends CustomerMessages