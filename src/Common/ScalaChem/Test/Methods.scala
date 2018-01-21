package Common.ScalaChem.Test

import Common.ScalaChem.Infrastructure.{ChemicalElement, IAtom, IMolecule}
import Common.ScalaChem.MolGraph.Atom

class Methods {

  //replace atom by
  def replaceAtoms_oop(g : IMolecule) = {
    var newElement = new Atom(ChemicalElement.C)
    for(i <- 0 to g.size - 1) g(i) = newElement
  }

  def replaceAtoms_fp(g : IMolecule) = {
    var newElement = new Atom(ChemicalElement.C)
    g.map( _ -> newElement)
  }

  //  zip
  def zipIt_oop (g : IMolecule) = {
    var ls1 = g
    var ls2 = g
    var listOfTuples  : List[(IAtom,IAtom)] = List()
    for(i <- 0 to g.size - 1) listOfTuples = listOfTuples :+ (g(i), g(i))
  }

  def zipIt_fp (g : IMolecule) = {
    var ls1 = g
    var ls2 = g
    ls1.zip(ls2)
  }

  //  filterByElement
  def filterByElement_oop(g : IMolecule) = {
    var ls = List[IAtom]()
    for(i <- 0 to g.size - 1) if(g(i).Element != ChemicalElement.C){ls = ls :+ g(i)}
  }

  def filterByElement_fp(g : IMolecule) = {
    g.filter((i: IAtom) => i != ChemicalElement.C)
  }

  //sum atomicnumbers
  def sumAtomicNumber_oop(g : IMolecule) = {
    var total = 0
    for(i <- 0 to g.size - 1) total = total + g(i).Element.id
  }

  def sumAtomicNumber_fp(g : IMolecule) = {
    g.map(a => a.Element.id).sum
  }

  // zipwith plus
  def zipWith_oop(g : IMolecule) = {
    var ls = List[Int]()
    for (i <- 0 to g.size - 1) ls =  ls :+ (g(i).Element.id + g(i).Element.id)
  }

  def zipWith_fp(g : IMolecule) = {
    var ls = g
    g.map(a => a.Element.id + a.Element.id)
  }

}
