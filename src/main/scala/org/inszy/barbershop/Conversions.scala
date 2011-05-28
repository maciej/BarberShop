package org.inszy.barbershop

import collection.mutable.Queue
import java.util.NoSuchElementException

/**
 * Created by IntelliJ IDEA.
 * User: Maciej Biłas
 * Date: 5/29/11
 * Time: 0:21
 */

object Conversions {

  implicit def toRichQueue[T](q: Queue[T]) = {
    new RichQueue(q)
  }

  class RichQueue[T](backingQueue: Queue[T]) {
    def dequeueOption() = {
      try {
        val element = backingQueue.dequeue()
        Some(element)
      } catch {
        case e: NoSuchElementException => None
        case e: Exception => throw e
      }
    }
  }

}

