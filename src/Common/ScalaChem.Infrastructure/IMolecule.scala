package Common.ScalaChem.Infrastructure

import Common.ScalaChem.Infrastructure.BondType.BondType

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

trait IMolecule extends mutable.MutableList[IAtom] {

  //
  // Returns neighbours of atom
  //
  def neighboursOf(atom: IAtom): scala.List[IBond]

  //
  // Creates a connection between two atoms a and b with bond type t
  //
  def connect(a : IAtom, b : IAtom, t : BondType) : Boolean

  def bonds() :  ListBuffer[IBond]
}