package ScalaChem.Infrastructure

trait IAtom {
    Element : ChemicalElement
    Connections : List[IBond]
}