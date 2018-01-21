package Common.ScalaChem.Infrastructure

import Common.ScalaChem.Infrastructure.BondType.BondType

trait IBond {

    var Type : BondType

    var From : IAtom
    
    var To : IAtom
}