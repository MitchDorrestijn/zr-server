package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.EntityManager;
import java.util.List;


public class DriverEntityManagerImpl extends GenericDAOImpl<DriverEntity> implements IDriverEntityManager{

    @Autowired
    public DriverEntityManagerImpl(EntityManager em) {
        super(em, DriverEntity.class);
    }


    @Override
    public DriverEntity findById(int id) {
        return (DriverEntity) super.findById(id);
    }

    @Override
    public List<DriverEntity> findAllDrivers() {
        return super.findAll();
    }

    @Override
    public void addDriver(DriverEntity driverEntity) {
        super.add(driverEntity);
    }

    @Override
    public void updateDriver(DriverEntity driverEntity) {
        super.update(driverEntity);
    }

    @Override
    public void deleteDriver(DriverEntity driverEntity) {
        super.remove(driverEntity);
    }
}
