import React, { Component } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { Container, Divider, Header } from 'semantic-ui-react';
import UserAPI from '../api/user';
import { Image, Title, Favorites, UserForm } from '../components';

class Book extends Component {
  constructor() {
    super();
    this.state = {
      user: {
        username: 'loading...',
        realname: 'Пупкин Вася Ибрагимович',
        favorites: [],
      },
    };
  }

  async componentDidMount() {
    this.fetchUser();
  }

  async fetchUser() {
    const userId = localStorage.getItem('userId');
    const response = await UserAPI.getUser(userId);
    const { data } = response;
    this.setState({ user: data });
  }

  render() {
    const { username, favorites } = this.state.user;
    const updateUser = this.fetchUser.bind(this);

    return (
      <Layout>
        <InfoRow>
          <Link to={{ pathname: '/' }}>Назад</Link>
        </InfoRow>
        <Header>Профиль { username }</Header>

        <UserForm user={this.state.user} />

        <Divider />
        <Favorites books={ favorites } redrawParent={updateUser} />
        <Divider />
      </Layout>
    );
  }
}

const InfoRow = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 16px;
`;

const Layout = styled(Container)`
  margin-top: 50px;
  margin-bottom: 150px;
`;

export default Book;
