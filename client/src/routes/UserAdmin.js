import React, {Component} from 'react';
import styled from 'styled-components';
import {Container, Header} from 'semantic-ui-react';
import UserAPI from '../api/user';
import UserRow from "../components/UserRow";
import {Link} from "react-router-dom";

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
      <Layout>
        <Link to={{ pathname: '/' }}>Назад</Link>
        <Header>Управление пользователями</Header>
        <table className="users-list">
          <tbody>
            {users.map((user, key) => <UserRow key={key} user={user} />)}
          </tbody>
        </table>
      </Layout>
    );
  }
}

const Layout = styled(Container)`
  margin-top: 50px;
  margin-bottom: 150px;
`;

export default UserAdmin;
