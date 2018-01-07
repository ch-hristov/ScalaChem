package Common.ScalaChem.MolGraph

import Common.ScalaChem.Infrastructure.ChemicalElement.ChemicalElement
import Common.ScalaChem.Infrastructure.{IAtom, IBond, IMolecule}

 class Atom(val element : ChemicalElement, var charge : Int = 0) extends IAtom {

  override var molecule : IMolecule = _

  override def equals(other: Any) = other match {
      case that: Atom => this.element == that.element
      case _ => false
  }
    
  override def toString() : String = {
   return this.element.toString
  }

  override var Element: ChemicalElement = this.element

  override def connections() : List[IBond] =
  {
     return this.molecule.neighboursOf(this)
  }

  //
  // You shouldn't call this method normally. I'm just currently too lazy to find a way
  // to restrict its visibility.
  //
  override def setMolecule(molecule: IMolecule): Unit = this.molecule=molecule

  var implicitHydrogens : Int = 0

  var explicitHydrogens : Int = 0
}