package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.CareinstitutionDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.ICareinstitutionDAO;
import org.han.ica.oose.boterbloem.domain.domainobjects.Address;
import org.han.ica.oose.boterbloem.domain.domainobjects.CareInstitution;
import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CareinstitutionMapper {

    private ICareinstitutionDAO careinstitutionDAO = new CareinstitutionDAOImpl();
    private static final Logger LOGGER = Logger.getLogger(CareinstitutionMapper.class.getName());

    /**
     * @return a list of domain objects CareInstitution
     */
    public List<CareInstitution> getAllCareinstitution() {
        List<CareInstitution> careInstitutions = new ArrayList<>();
        try {
            for (CareinstitutionEntity entity : careinstitutionDAO.findAll()) {
                CareInstitution careInstitution = new CareInstitution();
                List<Address> addresses = new ArrayList<>();
                Address address = new Address();
                address.setHouseNumber(entity.getHouseNumber());
                address.setResidence(entity.getResidence());
                address.setStreet(entity.getStreet());
                address.setZipCode(entity.getZipCode());
                addresses.add(address);
                careInstitution.setName(entity.getName());
                careInstitution.setAddresses(addresses);
                careInstitution.setId(entity.getId());
                careInstitutions.add(careInstitution);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return careInstitutions;
    }

    public void update(CareInstitution careInstitution) {
        List<Address> address = careInstitution.getAddresses();
        CareinstitutionEntity careinstitutionEntity = new CareinstitutionEntity();
        careinstitutionEntity.setId(careInstitution.getId());
        careinstitutionEntity.setName(careInstitution.getName());
        careinstitutionEntity.setResidence(address.get(0).getResidence());
        careinstitutionEntity.setZipCode(address.get(0).getZipCode());
        careinstitutionEntity.setHouseNumber(address.get(0).getHouseNumber());
        careinstitutionEntity.setStreet(address.get(0).getStreet());
        careinstitutionDAO.update(careinstitutionEntity);
    }

    public void saveCareInstitution(CareInstitution careInstitution) {
        List<Address> address = careInstitution.getAddresses();
        CareinstitutionEntity careinstitutionEntity = new CareinstitutionEntity();
        careinstitutionEntity.setId(careInstitution.getId());
        careinstitutionEntity.setName(careInstitution.getName());
        careinstitutionEntity.setResidence(address.get(0).getResidence());
        careinstitutionEntity.setZipCode(address.get(0).getZipCode());
        careinstitutionEntity.setHouseNumber(address.get(0).getHouseNumber());
        careinstitutionEntity.setStreet(address.get(0).getStreet());
        careinstitutionDAO.add(careinstitutionEntity);
    }
}
