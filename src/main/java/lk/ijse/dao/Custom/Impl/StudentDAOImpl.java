package lk.ijse.dao.Custom.Impl;

import lk.ijse.dao.Custom.StudentDAO;
import lk.ijse.entity.Student;
import lk.ijse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List getAll() throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM Student");
        nativeQuery.addEntity(Student.class);
        List nStudents = nativeQuery.getResultList();
        transaction.commit();
        session.close();
        return nStudents;
    }

    @Override
    public boolean add(Student student) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException, IOException {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        session.createNativeQuery("delete from Student where studentId='"+id+"'",Student.class).executeUpdate();
//        transaction.commit();
//        session.close();
//
//        return true;

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DELETE FROM student WHERE studentId = :sId";
        NativeQuery<Student> nativeQuery = session.createNativeQuery(sql);
        nativeQuery.setParameter("sId",id);
        nativeQuery.executeUpdate();

        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
