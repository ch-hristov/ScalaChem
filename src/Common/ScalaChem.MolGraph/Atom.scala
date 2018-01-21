package Common.ScalaChem.MolGraph

import Common.ScalaChem.Infrastructure.ChemicalElement.ChemicalElement
import Common.ScalaChem.Infrastructure.{IAtom, IBond, IMolecule}

 // An atom object that encapsulates an atom with an element in a molecue
 class Atom(val element : ChemicalElement, var charge : Int = 0) extends IAtom {

  override var molecule : IMolecule = _
    
  override def toString() : String = {
   return this.element.toString
  }

  override var Element: ChemicalElement = this.element

  // returns the neighbouring bonds of this atom
  override def connections() : List[IBond] =
  {
     return this.molecule.neighboursOf(this)
  }

  //
  // You shouldn't call this method normally. I'm just currently too lazy to find a way
  // to restrict its visibility.
  //
  override def setMolecule(molecule: IMolecule): Unit = this.molecule=molecule

  // The number of implicit hydrogens for this atom
  var implicitHydrogens : Int = 0

  // The number of explicit hydrogens (TODO: add a total number of hydrogens = implicit + explicit)
  var explicitHydrogens : Int = 0


}