package Common.ScalaChem.FunctionalMolGraph

import Common.ScalaChem.Infrastructure.BondType.BondType
import Common.ScalaChem.Infrastructure.{IAtom, IBond}

class Bond (val from : IAtom,val to :IAtom,val t :BondType) extends IBond {
  override var Type: BondType = this.t
  override var From: IAtom = this.from
  override var To: IAtom = this.to
}
