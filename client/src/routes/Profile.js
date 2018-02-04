import React, { Component } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { Container, Divider, Header } from 'semantic-ui-react';
import UserAPI from '../api/user';
import { Image, Title, Favorites } from '../components';

class Book extends Component {
  constructor() {
    super();
    this.state = {
      user: {
        username: 'loading...',
        favorites: [],
      },
    };
  }

  async componentDidMount() {
    this.updateUser();
  }

  async updateUser() {
    const userId = localStorage.getItem('userId');
    const response = await UserAPI.getUser(userId);
    const { data } = response;
    this.setState({ user: data });
  }

  render() {
    const { username, favorites, isAdmin } = this.state.user;
    const updateUser = this.updateUser.bind(this);
    // const { cover, title, authors, isbn, publisher, year, size, description } = this.state.book;
    return (
      <Layout>
        <InfoRow>
          <Link to={{ pathname: '/' }}>Назад</Link>
        </InfoRow>
        <Header>Профиль { username }</Header>

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
`;

const Layout = styled(Container)`
  margin-top: 50px;
  margin-bottom: 150px;
`;

export default Book;
