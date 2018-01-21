package Common.ScalaChem.MolGraph

import Common.ScalaChem.Infrastructure.BondType.BondType
import Common.ScalaChem.Infrastructure.{IAtom, IBond}

// A bond that connects two atoms.
// TODO: determine how to handle ionic bonds.
class Bond (val from : IAtom,val to :IAtom,val t :BondType) extends IBond {
  override var Type: BondType = this.t
  override var From: IAtom = this.from
  override var To: IAtom = this.to
}
