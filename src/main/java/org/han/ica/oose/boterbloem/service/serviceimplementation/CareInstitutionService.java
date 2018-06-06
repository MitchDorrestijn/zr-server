package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.ICareinstitutionDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.CareinstitutionDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.CareinstitutionEntity;
import org.han.ica.oose.boterbloem.domain.domainmappers.CareinstitutionMapper;
import org.han.ica.oose.boterbloem.domain.domainobjects.CareInstitution;
import org.han.ica.oose.boterbloem.service.ICareInstitutionService;

import java.util.List;

public class CareInstitutionService implements ICareInstitutionService {

    private ICareinstitutionDAO careinstitutionDAO = new CareinstitutionDAOImpl();
    private CareinstitutionMapper careinstitutionMapper = new CareinstitutionMapper();

    public CareInstitutionService() {
        // Empty constructor
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CareinstitutionEntity findById(int id) {
        return careinstitutionDAO.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List <CareInstitution> getAllCareInstitutions() {
        return careinstitutionMapper.getAllCareinstitution();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveCareInstitution(CareInstitution careInstitution) {
        careinstitutionMapper.saveCareInstitution(careInstitution);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCareInstitution(CareInstitution careInstitution) {
        careinstitutionMapper.update(careInstitution);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteCareInstitutionById(int id) {
        CareinstitutionEntity careinstitutionEntity = this.findById(id);
        careinstitutionDAO.remove(careinstitutionEntity);
    }

    /**
     * Getter for property 'careinstitutionDAO'.
     *
     * @return Value for property 'careinstitutionDAO'.
     */
    public ICareinstitutionDAO getCareinstitutionDAO() {
        return careinstitutionDAO;
    }

    /**
     * Setter for property 'careinstitutionDAO'.
     *
     * @param careinstitutionDAO Value to set for property 'careinstitutionDAO'.
     */
    public void setCareinstitutionDAO(ICareinstitutionDAO careinstitutionDAO) {
        this.careinstitutionDAO = careinstitutionDAO;
    }

    /**
     * Getter for property 'careinstitutionMapper'.
     *
     * @return Value for property 'careinstitutionMapper'.
     */
    public CareinstitutionMapper getCareinstitutionMapper() {
        return careinstitutionMapper;
    }

    /**
     * Setter for property 'careinstitutionMapper'.
     *
     * @param careinstitutionMapper Value to set for property 'careinstitutionMapper'.
     */
    public void setCareinstitutionMapper(CareinstitutionMapper careinstitutionMapper) {
        this.careinstitutionMapper = careinstitutionMapper;
    }

}