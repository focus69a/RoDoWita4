package com.onegday.rodowita4

data class Jestem_Upowazniony_Dane(var nazwa: String, var odKogo: String, var dlaKogo: String, var okres: String, var firma: String, var zakres: String, var zalaczniki: String)



object SupplierJestemUpowazniony {
    val upowaznieniaJestemUpowazniony = mutableListOf<Jestem_Upowazniony_Dane>(
            Jestem_Upowazniony_Dane("upowaznienie_1", "Anna Jackiewicz", "Waldemar Jackiewicz", "od 2018-09-01 od 2018-12-31", "PKOBP", "dyspozycje","D,M"),
            Jestem_Upowazniony_Dane("upowaznienie_2", "Anna Jackiewicz", "Waldemar Jackiewicz", "od 2018-09-01 od 2018-12-31", "Polkomtel", "dyspozycje","D,M"),
            Jestem_Upowazniony_Dane("upowaznienie_3", "Anna Jackiewicz", "Waldemar Jackiewicz", "od 2018-09-01 od 2020-12-31", "PGNiG", "odbior rachunkow","D,M"),
            Jestem_Upowazniony_Dane("upowaznienie_4", "Elzbieta Jackiewicz", "Waldemar Jackiewicz", "od 2018-09-01 od 2020-12-31", "PKOBP", "dyspozycje","D,M"),
            Jestem_Upowazniony_Dane("upowaznienie_5", "Elzbieta Jackiewicz", "Waldemar Jackiewicz", "od 2018-09-01 od 2019-12-31", "PGNiG", "dyspozycje","D,M"),
            Jestem_Upowazniony_Dane("upowaznienie_6", "Elzbieta Jackiewicz", "Waldemar Jackiewicz", "od 2018-09-01 od 2030-12-31", "PGE", "dyspozycje","D,M"),
            Jestem_Upowazniony_Dane("upowaznienie_7", "Anna Jackiewicz", "Waldemar Jackiewicz", "od 2018-09-01 od 2030-12-31", "PKOBP", "dyspozycje","D,M"),
            Jestem_Upowazniony_Dane("upowaznienie_8", "Anna Jackiewicz", "Waldemar Jackiewicz", "od 2018-09-01 od 2030-12-31", "mBank", "dyspozycje","D,M"),
            Jestem_Upowazniony_Dane("upowaznienie_9", "Anna Jackiewicz", "Waldemar Jackiewicz", "od 2018-09-01 od 2030-12-31", "Medicover", "odbior badan","D,M"),
            Jestem_Upowazniony_Dane("upowaznienie_10", "Anna Jackiewicz", "Waldemar Jackiewicz", "od 2018-09-01 od 2030-12-31", "Polkomtel", "dyspozycje","D,M"),
            Jestem_Upowazniony_Dane("upowaznienie_11", "Jakub Jackiewicz", "Waldemar Jackiewicz", "od 2018-09-01 od 2030-12-31", "Medicover", "odbior bradan","D,M"),
            Jestem_Upowazniony_Dane("upowaznienie_12", "Jakub Jackiewicz", "Waldemar Jackiewicz", "od 2018-09-01 od 2030-12-31", "PKOBP", "dyspozycje","D,M")

    )
}