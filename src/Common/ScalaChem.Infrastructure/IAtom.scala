package Common.ScalaChem.Infrastructure

import Common.ScalaChem.Infrastructure.ChemicalElement.ChemicalElement

trait IAtom {
    def setMolecule(molecule: IMolecule)
    def connections() : List[IBond]

    var molecule : IMolecule
    var Element : ChemicalElement

}