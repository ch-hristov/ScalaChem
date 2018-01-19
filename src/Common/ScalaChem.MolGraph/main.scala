package ScalaChem.MolGraph
import Common.ScalaChem.SMILES.MoleculeParser
import Common.ScalaChem.Test.{Methods, TestMethod, TestRunner}

object Main  extends App {
   override def main(args: Array[String]): Unit = {

     var sp = new MoleculeParser()
     var molecule = sp.parse("CC1CCC1")

     println(molecule.bonds().length);

     var func_runner = new TestRunner();
     var oop_runner = new TestRunner();

     var methods = new Methods()

     oop_runner.inject(new TestMethod(methods.zipIt_oop))
     oop_runner.inject(new TestMethod(methods.filterByElement_oop))
     oop_runner.inject(new TestMethod(methods.replaceAtoms_oop))
     oop_runner.inject(new TestMethod(methods.sumAtomicNumber_oop))

     //TODO: Niels inject the other methods
     func_runner.inject(new TestMethod(methods.zipIt_fp))
     func_runner.inject(new TestMethod(methods.filterByElement_fp))
     //func_runner.inject(new TestMethod(methods.replaceAtoms_fp))

     var k = 1000

     var ts_oop = System.nanoTime()
     oop_runner.run(molecule,k)
     var tf_oof = System.nanoTime()

     var ts_func = System.nanoTime()
     func_runner.run(molecule,k)
     var tf_func = System.nanoTime()

     println("OOP : " + (tf_oof - ts_oop).toString + " Func: " + (tf_func - ts_func).toString);
    }
}