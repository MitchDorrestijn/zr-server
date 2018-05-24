package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.han.ica.oose.boterbloem.entity.DrivercarEntity;
import org.han.ica.oose.boterbloem.entity.DrivercarEntityPK;

public interface IDriverDAO extends IGenericDAO<DriverEntity> {
<<<<<<< HEAD

    int latestId();
=======
    void deleteDriver(int driverId);
>>>>>>> 6064b35895394752e735eb28ee0b23d7a80b3147
}
