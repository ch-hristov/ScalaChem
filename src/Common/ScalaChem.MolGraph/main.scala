package ScalaChem.MolGraph
import Common.ScalaChem.SMILES.MoleculeParser

object Main  extends App {
   override def main(args: Array[String]): Unit = {
     var sp = new MoleculeParser()
     var molecule = sp.parse("CCCC1CCC1")
     println(molecule)
     println(molecule.bonds().length);
    }
}