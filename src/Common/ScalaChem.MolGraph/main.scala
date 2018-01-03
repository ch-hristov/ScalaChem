package ScalaChem.MolGraph
import ScalaChem.Infrastructure.ChemicalElement

object Main  extends App {
   override def main(args: Array[String]) {
     //create a new molecule
       var mol = new Molecule()
       mol.appendElem(new Atom(ChemicalElement.C,0));
       println("adssa")
    }
}