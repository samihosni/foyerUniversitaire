package com.example.foyerUniversitaire.Entity;

public enum TypeChambre {
    Simple(1),
    Double(2),
    Triple(3);

    private final int capaciteMax;

    TypeChambre(int capaciteMax){
        this.capaciteMax=capaciteMax;
    }
    public int getCapaciteMax(){
        return capaciteMax;
    }
}
