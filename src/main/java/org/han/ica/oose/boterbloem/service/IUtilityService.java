package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.domainobjects.Utility;

import java.util.List;

public interface IUtilityService {

    /**
     * GET all Utilities
     * @return list of Utilities
     */
    List<Utility> getAllUtilities();
}
