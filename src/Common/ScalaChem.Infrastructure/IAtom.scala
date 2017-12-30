package ScalaChem.Infrastructure
import ScalaChem.Infrastructure

trait IAtom {
    var molecule : IMolecule
    var Element : ChemicalElement
    var Connections : List[IBond]
}