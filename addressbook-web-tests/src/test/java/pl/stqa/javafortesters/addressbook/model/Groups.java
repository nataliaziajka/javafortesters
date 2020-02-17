package pl.stqa.javafortesters.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData> {

  protected Set<GroupData> delegate;

  public Groups(Groups groups) {
    this.delegate = new HashSet<GroupData>(groups.delegate);
  }

  public Groups() {
    this.delegate = new HashSet<GroupData>();
  }

  public Groups(Set<GroupData> groups) {
  }

  @Override
  protected Set<GroupData> delegate() {
    return delegate;
  }

  public Groups withAdded(GroupData group) {
    return null;
  }
  public Groups without(GroupData group) {
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }
}
