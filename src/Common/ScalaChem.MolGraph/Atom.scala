package ScalaChem.MolGraph
import ScalaChem.Infrastructure.{ChemicalElement, IAtom, IBond , IMolecule}

class Atom(val element : ChemicalElement, var charge : Int = 0, var molecule : IMolecule) extends IAtom {

    override def equals(other: Any) = other match {
        case that: Atom => this.element == that.element
        case _ => false
    }
    
    override def toString() : String = {s"Element: \n\tSymbol: $this.element\n\tCharge: $charge"
    }

   override var Element: ChemicalElement = this.element
   override var Connections: List[IBond] = this.molecule.neighboursOf(this)
}