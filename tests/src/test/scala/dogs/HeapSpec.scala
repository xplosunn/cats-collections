package dogs
package tests

import cats.implicits._

import scala.collection.Iterable

/**
 * Created by nperez on 3/28/16.
 */
class HeapSpec extends DogsSuite {
  implicit class IterableOps[A](as: Iterable[A]) {
    def toScalaList: List[A] = as.toList
  }

  test("sorted")(
    forAll { (xs: scala.List[Int]) =>

      val set = xs.toSet

      var heap = set.foldLeft(Heap.empty[Int])((h, i) => h.add(i))

      val exp = set.toList

      heap.toList should matchToSorted(exp)

    })
}