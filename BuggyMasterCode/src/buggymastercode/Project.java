/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buggymastercode;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.beanutils.DynaBean;

/**
 *
 * @author jalvarez
 */
public class Project {

    private String m_name = "";
    private String m_path = "";
    private int m_level = 0;
    private int m_id = 0;

    public void setId(int value) {m_id = value;}
    public int getId() {return m_id;}

    public String getName() {
        return m_name;
    }

    public void setName(String value) {
        m_name = value;
    }

    public String getPath() {
        return m_path;
    }

    public void setPath(String value) {
        m_path = value;
    }

    public int getLevel() {
        return m_level;
    }

    public boolean loadReferences() {
        int line = 1;
        ByRefString value = new ByRefString();
        String vbpFile = G.getFileForOS(m_path + "\\" + m_name);
        if (!deleteReferences())
            return false;
        if (G.getToken(vbpFile, "Reference", line, value)) {
            while (!value.text.isEmpty()) {
                if (!addReference(getReferenceName(value.text)))
                    return false;
                line++;
                if (!G.getToken(vbpFile, "Reference", line, value)) {
                    break;
                }
                //progressBar.setValue(line);
            }
        }
        return true;
    }

    public void getLevelFromReferences() {
        m_level = getLevelForReferenceName(m_name);
    }

    private boolean deleteReferences() {
        String sqlstmt = "delete treference where prj_id = " + Integer.toString(m_id);
        return Db.db.execute(sqlstmt);
    }

    public boolean save() {
        if (!getProjectIdFromProjectName())
            return false;

        if (m_id == Db.CS_NO_ID) {
            DataBaseId id = new DataBaseId();

            if (!Db.db.getNewId("tproject", id)) {
                return false;
            }
            else {
                m_id = id.getId();
            }

            String sqlstmt = "insert into tproject (prj_id, prj_name)"
                                + " values("
                                + Integer.toString(m_id)
                                + "," + Db.getString(m_name)
                                + ")";
            if (Db.db.execute(sqlstmt)) {
                return true;
            }
            else {
                return false;
            }
        }
        else
            return true;
    }

    private boolean addReference(String reference) {
        DataBaseId id = new DataBaseId();

        if (!Db.db.getNewId("treference", id)) {
            return false;
        }

        String sqlstmt = "insert into treference (prj_id, ref_id, ref_name)"
                            + " values("
                            + Integer.toString(m_id)
                            + "," + id.getId().toString()
                            + "," + Db.getString(reference)
                            + ")";
        if (Db.db.execute(sqlstmt)) {
            return true;
        }
        else {
            return false;
        }
    }

    private int getLevelForReferenceName(String reference) {
        int level = 0;
        int refLevel = 0;
        int prjId = getProjectIdFromName(reference);
        ArrayList<String>references = getReferencesList(prjId);
        if (references != null) {
            for (int i = 0; i < references.size(); i++) {
                refLevel = getLevelForReferenceName(references.get(i));
                if (level < refLevel) {
                    level = refLevel;
                }
            }
        }
        return level + 100;
    }

    public boolean getProjectIdFromProjectName() {
        G.setHourglass();
        setId(Db.CS_NO_ID);
        String sqlstmt = "select prj_id from tproject"
                            + " where prj_name = " + Db.getString(m_name);
        DBRecordSet rs = new DBRecordSet();
        if (!Db.db.openRs(sqlstmt, rs)) {
            G.setDefaultCursor();
            return false;
        }

        if (rs.getRows().isEmpty()) {
            G.setDefaultCursor();
            return true;
        }
        else {
            setId(((Number)(rs.getRows().get(0).get("prj_id"))).intValue());
            G.setDefaultCursor();
            return true;
        }
    }

    private int getProjectIdFromName(String reference) {
        G.setHourglass();
        String sqlstmt = "select prj_id from tproject where prj_name = "
                            + Db.getString(reference);
        DBRecordSet rs = new DBRecordSet();
        if (!Db.db.openRs(sqlstmt, rs)) {
            G.setDefaultCursor();
            return Db.CS_NO_ID;
        }

        if (rs.getRows().isEmpty()) {
            G.setDefaultCursor();
            return Db.CS_NO_ID;
        }
        else {
            G.setDefaultCursor();
            return ((Number)(rs.getRows().get(0).get("prj_id"))).intValue();
        }
    }

    private ArrayList<String> getReferencesList(int prjId) {
        G.setHourglass();
        String sqlstmt = "select ref_name from treference where prj_id = "
                            + Integer.toString(prjId);
        DBRecordSet rs = new DBRecordSet();
        if (!Db.db.openRs(sqlstmt, rs)) {
            G.setDefaultCursor();
            return null;
        }

        if (rs.getRows().isEmpty()) {
            G.setDefaultCursor();
            return null;
        }
        else {
            ArrayList<String> list = new ArrayList<String>();
            G.setDefaultCursor();
            for (Iterator<DynaBean> j = rs.getRows().iterator(); j.hasNext();) {
                DynaBean row = j.next();
                list.add(row.get("ref_name").toString());
            }
            return list;
        }
    }

    private String getReferenceName(String reference) {
        boolean sharpFound = false;
        String rtn = "";
        for (int i = reference.length()-1; i >-1; i--) {
            if (sharpFound) {
                if (reference.charAt(i) == '\\')
                    break;
                rtn = reference.charAt(i) + rtn;
            }
            else if (reference.charAt(i) == '#') {
                sharpFound = true;
            }
        }
        return rtn;
    }
}
