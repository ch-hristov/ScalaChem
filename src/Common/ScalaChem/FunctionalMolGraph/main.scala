package Common.ScalaChem.FunctionalMolGraph

import Common.ScalaChem.Test.{Test, TestRunner}

import scala.collection.mutable.ListBuffer

object Main  extends App {
  override def main(args: Array[String]): Unit = {

    var runner : TestRunner = new TestRunner()

    var test_items = new ListBuffer[Test]()

    //Niels add stuff in test_items

    b.foreach(x => runner.inject(x))

    runner.run(5)
  }
}