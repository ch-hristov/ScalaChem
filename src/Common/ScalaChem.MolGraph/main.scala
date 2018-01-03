package ScalaChem.MolGraph
import java.nio.CharBuffer

import Common.ScalaChem.MolGraph.{Atom, Molecule}
import Common.ScalaChem.SMILES.SmilesParser
import ScalaChem.Infrastructure.ChemicalElement

object Main  extends App {
   override def main(args: Array[String]): Unit = {
     var sp = new SmilesParser()
     var molecule = sp.parseSmiles("CCCC");
     println(molecule)
    }
}