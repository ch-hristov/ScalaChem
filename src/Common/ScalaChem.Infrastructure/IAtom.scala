package ScalaChem.Infrastructure
import ScalaChem.Infrastructure

trait IAtom {
    var Element : ChemicalElement
    var Connections : List[IBond]
}