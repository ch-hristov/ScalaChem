package ScalaChem.MolGraph
import ScalaChem.Infrastructure.{ChemicalElement, IAtom, IBond}

class Atom(val aid : Int, val anum : ChemicalElement, var charge : Int = 0) extends IAtom {
    /**  
	 * Override the equals method for Atoms
	 * With this, expressions like a1 equals a2 or a1==a2 will work if all values are the same. 
	 */
    override def equals(other: Any) = other match {
        case that: Atom => this.anum == that.anum
        case _ => false
    }
    
    override def toString() : String = {
        val elem = this.anum
        s"Element: \n\tSymbol: $elem\n\tAtomic Number: $anum\n\tCharge: $charge"
    }

  override var Element: ChemicalElement = _
  override var Connections: List[IBond] = _
}