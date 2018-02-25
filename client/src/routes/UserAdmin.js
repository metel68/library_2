import React, {Component} from 'react';
import {Header} from 'semantic-ui-react';
import UserAPI from '../api/user';
import UserRow from "../components/UserRow";
import SiteContainer from "../components/SiteContainer";

class UserAdmin extends Component {
  constructor() {
    super();
    this.state = {
      users: [],
    };
  }

  async componentDidMount() {
    await this.fetchUsers();
  }

  async fetchUsers() {
    const response = await UserAPI.getUsers();
    const {data} = response;
    this.setState({users: data});
  }

  render() {
    const {users} = this.state;

    return (
      <SiteContainer>
        <Header>Управление пользователями</Header>
        <table className="users-list">
          <tbody>
            {users.map((user, key) => <UserRow key={key} user={user} />)}
          </tbody>
        </table>
      </SiteContainer>
    );
  }
}

export default UserAdmin;
