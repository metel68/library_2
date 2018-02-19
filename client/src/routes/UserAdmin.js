import React, {Component} from 'react';
import styled from 'styled-components';
import {Link} from 'react-router-dom';
import {Container} from 'semantic-ui-react';
import UserAPI from '../api/user';
import UserRow from "../components/UserRow";

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
        <table className="users-list">
          {users.map((user, key) => <UserRow key={key} user={user} />)}
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
