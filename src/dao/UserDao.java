package dao;

import java.util.ArrayList;
import java.util.List;
import model.EmpException;
import model.User;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import util.XMLUtil;

public class UserDao {

  public static final String USER_XML = "users";
  private Document ud;

  public UserDao() {
    this.ud = XMLUtil.getUserDocument();
  }

  private void write() {
    XMLUtil.write2XML(ud, USER_XML);
  }

  public void add(User user) {
    if (user.getUsername() == null || user.getUsername().equals("")) {
      throw new EmpException("User name cant be empty.");
    }
    User u = this.load(user.getUsername());
    if (u != null) {
      throw new EmpException("The username was already exist.");
    }
    Element e = ud.getRootElement().addElement("user");
    e.addElement("username").addText(user.getUsername());
    e.addElement("password").addText(user.getPassword());
    e.addElement("nickname").addText(user.getNickname());
    write();
  }

  private Element loadElementByUsername(String username) {
    String path = "/users/user[username='" + username + "']";
    Element e = (Element) ud.selectSingleNode(path);
    return e;
  }

  private User elementToUser(Element e){
    User u = new User();
    u.setNickname(e.elementText("nickname"));
    u.setPassword(e.elementText("password"));
    u.setUsername(e.elementText("username"));
    return u;
  }
  public void delete(String username) {
    Element root = ud.getRootElement();
    Element u = loadElementByUsername(username);
    root.remove(u);
    write();
  }

  public void update(User user) {
    Element e = loadElementByUsername(user.getUsername());
    if(e==null) throw  new EmpException("User name given not found");
    e.element("password").setText(user.getPassword());
    e.element("nickname").setText(user.getNickname());
  }

  public User load(String username) {
    Element e = loadElementByUsername(username);
    if (e == null) {
      return null;
    }
    return elementToUser(e);
  }

  public List<User> list() {
    String path ="/users/user";
    List<Node> eles =ud.selectNodes(path);
    List<User> users = new ArrayList<>();
    for (Node d:eles){
      users.add(elementToUser((Element)d));//by force
    }
    return users;
  }

  public static void main(String[] args) {
    UserDao u = new UserDao();
    User user = new User();
    user.setUsername("inini");
    user.setPassword("agag");
    user.setNickname("papap");
    u.delete("inini");
    u.add(user);
    User update = new User();
    update.setUsername("inini");
    update.setNickname("hahaha");
    u.update(user);
  }
}