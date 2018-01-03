package ScalaChem.Infrastructure
import ScalaChem.Infrastructure

import scala.collection.mutable

trait IMolecule extends mutable.MutableList[IAtom] {

  //
  // Returns neighbours of atom
  //
  def neighboursOf(atom: IAtom): scala.List[_root_.ScalaChem.Infrastructure.IBond]

  //
  // Creates a connection between two atoms a and b with bond type t
  //
  def connect(a : IAtom, b : IAtom, t : BondType) : Boolean
}