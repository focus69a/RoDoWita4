package com.onegday.rodowita4

data class Ja_Upowaznilem_Dane(var nazwa: String, var odKogo: String, var dlaKogo: String, var okres: String, var firma: String, var zakres: String, var zalaczniki: String)



object SupplierJaUpowaznilem {
    val upowaznieniaJaUpowaznilem = mutableListOf<Ja_Upowaznilem_Dane>(
            Ja_Upowaznilem_Dane("upowaznienie_1", "Waldemar Jackiewicz", "Anna Jackiewicz", "od 2018-09-01 od 2018-12-31", "PKOBP", "dyspozycje", "D,M"),
            Ja_Upowaznilem_Dane("upowaznienie_2", "Waldemar Jackiewicz", "Anna Jackiewicz", "od 2018-09-01 od 2018-12-31", "Polkomtel", "dyspozycje","D,M"),
            Ja_Upowaznilem_Dane("upowaznienie_3", "Waldemar Jackiewicz", "Anna Jackiewicz", "od 2018-09-01 od 2020-12-31", "PGNiG", "odbior rachunkow","D,M"),
            Ja_Upowaznilem_Dane("upowaznienie_4", "Waldemar Jackiewicz", "Elzbieta Jackiewicz", "od 2018-09-01 od 2020-12-31", "PKOBP", "dyspozycje","D,M"),
            Ja_Upowaznilem_Dane("upowaznienie_5", "Waldemar Jackiewicz", "Elzbieta Jackiewicz", "od 2018-09-01 od 2019-12-31", "PGNiG", "dyspozycje","D,M"),
            Ja_Upowaznilem_Dane("upowaznienie_6", "Waldemar Jackiewicz", "Elzbieta Jackiewicz", "od 2018-09-01 od 2030-12-31", "PGE", "dyspozycje","D,M"),
            Ja_Upowaznilem_Dane("upowaznienie_7", "Waldemar Jackiewicz", "Elzbieta Jackiewicz", "od 2018-09-01 od 2030-12-31", "PKOBP", "dyspozycje","D,M"),
            Ja_Upowaznilem_Dane("upowaznienie_8", "Waldemar Jackiewicz", "Jakub Jackiewicz", "od 2018-09-01 od 2030-12-31", "mBank", "dyspozycje","D,M"),
            Ja_Upowaznilem_Dane("upowaznienie_9", "Waldemar Jackiewicz", "Jakub Jackiewicz", "od 2018-09-01 od 2030-12-31", "Medicover", "odbior badan","D,M"),
            Ja_Upowaznilem_Dane("upowaznienie_10", "Waldemar Jackiewicz", "Anna Jackiewicz", "od 2018-09-01 od 2030-12-31", "Polkomtel", "dyspozycje","D,M"),
            Ja_Upowaznilem_Dane("upowaznienie_11", "Waldemar Jackiewicz", "Anna Jackiewicz", "od 2018-09-01 od 2030-12-31", "Medicover", "odbior bradan","D,M"),
            Ja_Upowaznilem_Dane("upowaznienie_12", "Waldemar Jackiewicz", "Anna Jackiewicz", "od 2018-09-01 od 2030-12-31", "PKOBP", "dyspozycje","D,M")

    )
}