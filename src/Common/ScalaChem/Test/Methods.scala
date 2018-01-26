package Common.ScalaChem.Test

import Common.ScalaChem.Infrastructure.{ChemicalElement, IAtom, IMolecule}
import Common.ScalaChem.MolGraph.Atom
import Common.ScalaChem.MolGraph.Molecule

class Methods {

  //replace atom by
  def replaceAtoms_oop(g : Molecule) = {
    var newElement = new Atom(ChemicalElement.C)
//    for(i <- g.Graph.keys.size) g.Graph.update(newElement, i)
  }

  def replaceAtoms_fp(g : Molecule) = {
    var newElement = new Atom(ChemicalElement.C)
    g.Graph.map(_ -> newElement)
    //g.keys.map( _ -> newElement)
  }

  //  zip
  def zipIt_oop (g : IMolecule) = {
    var ls1 = g
    var ls2 = g
    var listOfTuples  : List[(IAtom,IAtom)] = List()
    //for(i <- 0 to g.keys.size - 1) listOfTuples = listOfTuples :+ (g.keys(i), g.keys(i))
  }

  def zipIt_fp (g : Molecule) = {
    var ls1 = g.Graph
    var ls2 = g.Graph
    ls1.zip(ls2)
  }

  //  filterByElement
  def filterByElement_oop(g : IMolecule) = {
    var ls = List[IAtom]()
    //for(i <- 0 to g.size - 1) if(g(i).Element != ChemicalElement.C){ls = ls :+ g(i)}
  }

  def filterByElement_fp(g : Molecule) = {
//    g.Graph.filter((i : IAtom) => i.Element != ChemicalElement.C)
//    filterByElement_oop(g)
  }

  //sum atomicnumbers
  def sumAtomicNumber_oop(g : IMolecule) = {
    var total = 0
    //for(i <- 0 to g.size - 1) total = total + g(i).Element.id
  }

  def sumAtomicNumber_fp(g : Molecule) = {
//    g.Graph.map(a => a.Element.id).sum
  }

  // zipwith plus
  def zipWith_oop(g : IMolecule) = {
    var ls = List[Int]()
    //for (i <- 0 to g.size - 1) ls =  ls :+ (g(i).Element.id + g(i).Element.id)
  }

  def zipWith_fp(g : Molecule) = {
    var ls = g.Graph
//    g.map(a => a.Element.id + a.Element.id)
  }

}
