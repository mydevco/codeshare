package com.mydevco.lambda.model;

import java.util.Optional;

public class OptProjectManager {

    private String name;

    public String getName() {
        return name;
    }

    private Optional<PMPCertificate> pmp;

    public OptProjectManager(String name, Optional<PMPCertificate> pmp) {
        this.name = name;
        this.pmp = pmp;
    }

    public Optional<PMPCertificate> getPmp() {
        return pmp;
    }

}
