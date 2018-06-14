package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.domain.domainmappers.UtilityMapper;
import org.han.ica.oose.boterbloem.domain.domainobjects.Utility;
import org.han.ica.oose.boterbloem.service.IUtilityService;

import java.util.List;

public class UtilityService implements IUtilityService {

    private UtilityMapper utilityMapper = new UtilityMapper();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Utility> getAllUtilities() {
        return utilityMapper.getAllUtilities();
    }

    @Override
    public void setUtilityMapper(UtilityMapper utilityMapper) {
        this.utilityMapper = utilityMapper;
    }
}
