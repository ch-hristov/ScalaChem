package ScalaChem.Infrastructure
import ScalaChem.Infrastructure

trait IBond {
    var Type : BondType
    var From : IAtom
    var To : IAtom
}