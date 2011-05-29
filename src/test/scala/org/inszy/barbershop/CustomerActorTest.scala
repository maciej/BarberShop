package org.inszy.barbershop

import org.scalatest.matchers.ShouldMatchers
import akka.testkit.TestActorRef
import scala.Some
import org.scalatest.{GivenWhenThen, FlatSpec}

/**
 * Created by IntelliJ IDEA.
 * User: Maciej Biłas
 * Date: 5/29/11
 * Time: 12:56
 */

class CustomerActorTest extends FlatSpec with ShouldMatchers with GivenWhenThen {

  it should "say it's named when asked for it" in {
    given("A customer name and a Customer actor.")
    val customerName = "Tony"
    val customerRef = new TestActorRef(() => new Customer(customerName)).start()

    when("Asked for the name.")
    val actualName = customerRef !! AskForName

    then("Named the actor replied with should be its name.")
    assert(actualName === Some(customerName))
  }

  it should "kill itself when asked to leave" in {
    
  }
}