package ScalaChem.MolGraph
import Common.ScalaChem.SMILES.SmilesParser

object Main  extends App {
   override def main(args: Array[String]): Unit = {
     var sp = new SmilesParser()
     var molecule = sp.parseSmiles("CCCC");
     println(molecule.toString())
    }
}