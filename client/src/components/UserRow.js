import React, {Component} from 'react';

export default class UserRow extends Component {
  getUserUrl = () => `/user/${this.props.user.id}`;

  render() {
    const {user} = this.props;

    return (
      <tr className="user-row">
        <td>{user.realname}&nbsp;
        (<a className="user-edit" href={this.getUserUrl()}>
          {user.username}
        </a>)
        </td>
        <td>
          <a className="user-remove" href="#">Удалить</a>
        </td>
      </tr>
    );
  }
}