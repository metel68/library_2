import React, {Component} from 'react';
import {Divider, Header} from 'semantic-ui-react';
import UserAPI from '../api/user';
import API from '../api/Api';
import UserRow from "../components/UserRow";
import SiteContainer from "../components/SiteContainer";
import CategoryRow from "../components/CategoryRow";

class UserAdmin extends Component {
  constructor() {
    super();
    this.state = {
      users: [],
      categories: []
    };
  }

  async componentDidMount() {
    await this.fetchUsers();
    await this.fetchCategories();
  }

  async fetchUsers() {
    const response = await UserAPI.getUsers();
    const {data} = response;
    this.setState({users: data});
  }

  async fetchCategories() {
    const response = await API.getCategories();
    const {data} = response;
    this.setState({categories: data});
  }

  render() {
    const {users, categories} = this.state;

    return (
      <SiteContainer>
        <Header>Управление пользователями</Header>
        <table className="users-list">
          <tbody>
            {users.map((user, key) => <UserRow key={key} user={user} />)}
          </tbody>
        </table>
        <Divider />
        <Header>Управление категориями</Header>
        <table className="category-list">
          <tbody>
            {categories.map((category, key) => <CategoryRow key={key} category={category} />)}
          </tbody>
        </table>
      </SiteContainer>
    );
  }
}

export default UserAdmin;
