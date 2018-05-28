package org.han.ica.oose.boterbloem.domain;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {

    private String companion; // Supervisor of the client
    private byte warningPKB; // Show warning
    private int PKB; // Personal kilometer budget
    private byte companionRequired; // A superviser is required
    private String image;
    private String bankAccount; // bankaccount number.
    private List<Limitation> limitations =  new ArrayList<>();


}
