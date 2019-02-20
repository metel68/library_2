import React, { Component } from 'react';
import { Divider, Header } from 'semantic-ui-react';
import UserAPI from '../api/user';
import { Favorites, UserForm } from '../components';
import SiteContainer from "../components/SiteContainer";

class Profile extends Component {
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
    await this.fetchUser();
  }

  async fetchUser() {
    const userId = this.props.match.params.id || localStorage.getItem('userId');
    const response = await UserAPI.getUser(userId);
    const { data } = response;
    this.setState({ user: data });
  }

  render() {
    const { username, favorites } = this.state.user;
    const updateUser = this.fetchUser.bind(this);

    return (
      <SiteContainer>
        <Header>Профиль { username }</Header>

        <UserForm user={this.state.user} />

        <Divider />
        <Favorites books={ favorites } redrawParent={updateUser} />
        <Divider />
      </SiteContainer>
    );
  }
}

export default Profile;
