package db;

import db.util.JsfUtil;
import db.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;

@Named("znajomiController")
@ViewScoped
public class ZnajomiController implements Serializable {

    @EJB
    private db.ZnajomiFacade ejbFacade;
    private List<Znajomi> items = null;
    private Znajomi selected;

    public ZnajomiController() {
    }

    public Znajomi getSelected() {
        return selected;
    }

    public void setSelected(Znajomi selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ZnajomiFacade getFacade() {
        return ejbFacade;
    }

    public Znajomi prepareCreate() {
        selected = new Znajomi();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ZnajomiCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ZnajomiUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ZnajomiDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Znajomi> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Znajomi getZnajomi(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Znajomi> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Znajomi> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }
    public List<Znajomi> getItems(Integer id) {
        List<Znajomi> znajomi = new ArrayList<Znajomi>();
        this.getItems().stream().filter(p->p.getIdznajomego().getIduzytkownika().equals(id)).forEach(p->znajomi.add(p));
        return znajomi; 
    }
    public List<Integer> getId(Integer id)
    {
       List<Integer> ids = new ArrayList<Integer>();
       this.getItems(id).stream().forEach(p->{ids.add(p.getIduzytkownika().getIduzytkownika());ids.add(p.getIdznajomego().getIduzytkownika());});
       List<Integer> idy = new ArrayList<Integer>();
       ids.stream().distinct().forEach(p->idy.add(p));
       return idy;
    }
      public List<Integer> getId(List<Znajomi> znajomi,Integer id)
    {
       List<Integer> ids = new ArrayList<Integer>();
       for(Znajomi zna : znajomi)
       {
           if (zna.getIduzytkownika().getIduzytkownika()==id)
               ids.add(zna.getIdznajomego().getIduzytkownika());
           if (zna.getIdznajomego().getIduzytkownika()==id)
               ids.add(zna.getIduzytkownika().getIduzytkownika());
       }
       return ids;
    }
    public List<Integer> tolist(List<Znajomi> znajomi, Integer id)
    {
       List<Integer> lista = new ArrayList<>();
       znajomi.stream().mapToInt(p->p.getIduzytkownika().getIduzytkownika()).distinct().forEach(p->{if(p!=id)lista.add(p);});
       znajomi.stream().mapToInt(p->p.getIdznajomego().getIduzytkownika()).distinct().forEach(p->{if(p!=id)lista.add(p);});
       return lista;
    }
    @FacesConverter(forClass = Znajomi.class)
    public static class ZnajomiControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ZnajomiController controller = (ZnajomiController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "znajomiController");
            return controller.getZnajomi(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Znajomi) {
                Znajomi o = (Znajomi) object;
                return getStringKey(o.getIdznajomosci());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Znajomi.class.getName()});
                return null;
            }
        }

    }

}
